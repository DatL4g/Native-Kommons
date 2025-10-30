package dev.datlag.kommons


data object Ukraine : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("UA")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("UKR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(804)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(380)
}