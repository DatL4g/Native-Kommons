package dev.datlag.kommons


data object GuineaBissau : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GNB")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(624)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(245)
}