package dev.datlag.kommons


data object SaintKittsAndNevis : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KN")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KNA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(659)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1869)
}