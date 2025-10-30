package dev.datlag.kommons


data object Kyrgyzstan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KGZ")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(417)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(996)
}